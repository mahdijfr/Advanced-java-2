abstract class Creature {
    protected final String name;

    public Creature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String answer();

    @Override
    public boolean equals(Object o) {
        if (o instanceof Creature) {
            return this.answer().equals(((Creature) o).answer());
        }
        return false;
    }
}

abstract class SeaCreature extends Creature {
    public SeaCreature(String name) {
        super(name);
    }
}

abstract class Bird extends Creature {
    public Bird(String name) {
        super(name);
    }
}

abstract class LandCreature extends Creature {
    public LandCreature(String name) {
        super(name);
    }
}

class Eagle extends Bird {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public String answer() {
        return "Scream";
    }
}

class Hawk extends Bird {
    public Hawk(String name) {
        super(name);
    }

    @Override
    public String answer() {
        return "Even more scream";
    }
}

class RoadRunner extends Bird {
    public RoadRunner() {
        super("Road Runner");
    }

    @Override
    public String answer() {
        return "MigMig (Not MugMug, that's Pingu)";
    }
}

class Elephant extends LandCreature {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public String answer() {
        return "Roars in trunk";
    }
}

class NinjaTurtle extends LandCreature {
    public NinjaTurtle(String name) {
        super(name);
    }

    @Override
    public String answer() {
        switch (name) {
            case "Leonardo": {
                return "Did you see my Katanas recently?";
            }
            case "Raphael": {
                return "This place is a mess";
            }
            case "Donatello": {
                return "They say I'm the Nerd :(";
            }
            case "Michelangelo": {
                return "A Pepperoni please, with extra cheese";
            }
        }
        return "My name is Splinter and no, I'm not a Turtle";
    }
}

class Coyote extends LandCreature {
    public Coyote() {
        super("Wile E. Coyote");
    }

    @Override
    public String answer() {
        return "Yet another mind-blowing law-bending idea that won't work";
    }
}

class BabyShark extends SeaCreature {
    public BabyShark() {
        super("Baby Shark");
    }

    @Override
    public String answer() {
        return "Baaaby shark dodo, dodo dodo";
    }
}

class SpongeBob extends SeaCreature {
    public SpongeBob() {
        super("SpongeBob SquarePants");
    }

    @Override
    public String answer() {
        return "Are you ready kids?";
    }
}

class Patrick extends SeaCreature {
    public Patrick() {
        super("Patrick Star");
    }

    @Override
    public String answer() {
        return "The inner machinations of my mind are an enigma (It's actually a Quote)";
    }
}