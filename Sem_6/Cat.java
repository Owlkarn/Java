package Sem_6;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat {
    private String name;
    private String owner;
    private String breed;
    private LocalDate birthDate;
    private String colour;
    private ArrayList<Vaccination> vaccinations = new ArrayList<>();

    public Cat(String name, String owner, String breed, LocalDate birthDate, String colour) {
        this.name = name;
        this.owner = owner;
        this.breed = breed;
        this.birthDate = birthDate;
        this.colour = colour;
    }

    

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == this) return true;
    //     if (obj == null) return false;
    //     if (!(obj instanceof Cat)) return false;
    //     Cat other = (Cat) obj;
    //     return this.name.equals(other.name) && this.birthDate.equals(other.birthDate) && this.owner.equals(other.owner)
    //     && this.breed.equals(other.breed) && this.colour.equals(other.colour);
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        result = prime * result + ((colour == null) ? 0 : colour.hashCode());
        result = prime * result + ((vaccinations == null) ? 0 : vaccinations.hashCode());
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
        Cat other = (Cat) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (owner == null) {
            if (other.owner != null)
                return false;
        } else if (!owner.equals(other.owner))
            return false;
        if (breed == null) {
            if (other.breed != null)
                return false;
        } else if (!breed.equals(other.breed))
            return false;
        if (birthDate == null) {
            if (other.birthDate != null)
                return false;
        } else if (!birthDate.equals(other.birthDate))
            return false;
        if (colour == null) {
            if (other.colour != null)
                return false;
        } else if (!colour.equals(other.colour))
            return false;
        if (vaccinations == null) {
            if (other.vaccinations != null)
                return false;
        } else if (!vaccinations.equals(other.vaccinations))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cat [name=" + name + ", owner=" + owner + ", breed=" + breed + ", birthDate=" + birthDate + ", colour="
                + colour + ", vaccinations=" + vaccinations + "]\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getColour() {
        return colour;
    }
    
    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }
}
