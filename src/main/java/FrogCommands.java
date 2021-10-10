public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean doit() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(-steps);
            }
        };
        return frogCommand;
    }
    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        FrogCommand frogCommand = new FrogCommand() {

            @Override
            public boolean doit() {
                return frog.jump(-steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(steps);
            }
        };
        return frogCommand;
    }
}
