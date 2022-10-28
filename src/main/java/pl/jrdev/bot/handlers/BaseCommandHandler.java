package pl.jrdev.bot.handlers;

abstract class BaseCommandHandler implements CommandHandler {

    @Override
    public boolean canHandle(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();
}