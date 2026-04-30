enum MenuChoice{
    ADD_BOOK(1),
    SHOW_BOOKS(2),
    FIND_BY_ID(3),
    REMOVE_BOOK(4),
    FIND_BY_TITLE(5),
    SHOW_EXPENSIVE(6),
    SORT_BOOKS(7),
    SHOW_STATISTIC(8),
    FIND_BY_AUTHOR(9),
    EXIT(0);

    private final int value;

    MenuChoice(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    public static MenuChoice fromInt(int choice){
        for (MenuChoice command : MenuChoice.values()){
            if(command.getValue() == choice){
                return command;
            }
        }
        return null;
    }
}
