package maze.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoxMouseAdapter extends MouseAdapter {
    private final BoxPanel boxPanel;

    public BoxMouseAdapter(BoxPanel boxPanel) {
        this.boxPanel = boxPanel;
    }

    private MazePanel getMazePanel() {
        return (MazePanel) boxPanel.getParent();
    }

    @Override
    public void mousePressed(final MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON1) {
            final MazePanel mazePanel = getMazePanel();
            final AbstractBoxTypeRadioButton radioButton = mazePanel.getSelectedBoxTypeButton();

            if (radioButton != null) {
                radioButton.setBoxModelType(boxPanel.getMazeBox());
            }
        }
    }
}
