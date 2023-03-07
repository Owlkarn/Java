package Homework.Sem_6;

public class Notebook {
    private String breed;
    private int memory;
    private int ram;
    private String os;
    private String colour;
    private String proc;

    public Notebook(String breed, int memory, int ram, String os, String colour, String proc) {
        this.breed = breed;
        this.memory = memory;
        this.ram = ram;
        this.os = os;
        this.colour = colour;
        this.proc = proc;
    }

    @Override
    public String toString() {
        return "Notebook [breed=" + breed + ", memory=" + memory + ", ram=" + ram + ", os=" + os + ", colour=" + colour
                + ", proc=" + proc + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + memory;
        result = prime * result + ram;
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((colour == null) ? 0 : colour.hashCode());
        result = prime * result + ((proc == null) ? 0 : proc.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (breed == null) {
            if (other.breed != null)
                return false;
        } else if (!breed.equals(other.breed))
            return false;
        if (memory != other.memory)
            return false;
        if (ram != other.ram)
            return false;
        if (os == null) {
            if (other.os != null)
                return false;
        } else if (!os.equals(other.os))
            return false;
        if (colour == null) {
            if (other.colour != null)
                return false;
        } else if (!colour.equals(other.colour))
            return false;
        if (proc == null) {
            if (other.proc != null)
                return false;
        } else if (!proc.equals(other.proc))
            return false;
        return true;
    }

    public String getBreed() {
        return breed;
    }

    public int getMemory() {
        return memory;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public String getColour() {
        return colour;
    }

    public String getProc() {
        return proc;
    }    
    
    
}
