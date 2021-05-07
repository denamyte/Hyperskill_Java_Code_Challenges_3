interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int storeIndex = -1;

    @Override
    public void execute() {
        int index = -1;
        while (++index < entity.getInventoryLength()) {
            if (entity.getInventoryItem(index) == null) {
                entity.setInventoryItem(index, item);
                storeIndex = index;
                break;
            }
        }
    }

    @Override
    public void undo() {
        if (storeIndex > -1) {
            entity.setInventoryItem(storeIndex, null);
        }
    }
}