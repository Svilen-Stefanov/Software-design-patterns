package edu.tum.cs.i1.eist;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ItemListener {


	private static final long serialVersionUID = 1L;
	
	private Game game;
	
    private Action startAction;
    private Action stopAction;
    
    private JComboBox<Object> strategyBox = new JComboBox<Object>();

    public ToolBar(Game game) {
        super();

        ArrayList<Object> strategies = CollisionStrategy.getSTRATEGIES();
        Iterator<Object> iter = strategies.iterator();
        while (iter.hasNext()) {
            strategyBox.addItem(iter.next());
        }
        strategyBox.setSelectedItem(game.gameBoard.referee.getCollisionStrategy());
        strategyBox.addItemListener(this);

        setFloatable(false);
        initActions();
        add(startAction);
        add(stopAction);
        addSeparator();
        
        add(new JLabel("Collision Strategy:"));
        add(strategyBox);

        this.game = game;
        game.gameBoard.setup();
        enableButtons();
    }

    private void initActions() {
        startAction = new AbstractAction("start") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
                game.gameBoard.referee.startGame();
            }
        };

        stopAction = new AbstractAction("stop") {

            private static final long serialVersionUID = 1L;

            public void actionPerformed(ActionEvent e) {
            	game.gameBoard.referee.stopGame();
                int ret = JOptionPane.showConfirmDialog(null,
                        "Do you really want to stop the game ?",
                        "Stop Game Confirmation", JOptionPane.YES_NO_OPTION);
                if (ret == 0) {
                	game.gameBoard.setup();
                } else {
                	game.gameBoard.referee.startGame();
                }
            }
        };
    }

	public void enableButtons() {
		startAction.setEnabled(!game.gameBoard.referee.isRunning());
		stopAction.setEnabled(game.gameBoard.referee.isRunning());
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		CollisionStrategy selectedCollision = (CollisionStrategy) strategyBox.getSelectedItem();
		game.gameBoard.referee.setCollisionStrategy(selectedCollision);
	}

}
