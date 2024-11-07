package presenter;

import view.InputView;
import view.MessageView;

public class CommandHandler {
    private TreePresenter presenter;
    private MessageView messageView;
    private InputView inputView;

    public CommandHandler(TreePresenter presenter, MessageView messageView, InputView inputView) {
        this.presenter = presenter;
        this.messageView = messageView;
        this.inputView = inputView;
    }

    public void handleUserInput() {
        while (true) {
            messageView.displayMessage("Enter command (add, list, sortByName, sortByBirthYear, save, load, exit):");
            String command = inputView.getUserInput();
            presenter.handleCommand(command);
        }
    }
}
