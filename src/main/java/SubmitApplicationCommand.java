public class SubmitApplicationCommand implements Command {
    private final AccountManager accountManager;

    public SubmitApplicationCommand(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public void execute() {
        accountManager.submit();
    }
}
