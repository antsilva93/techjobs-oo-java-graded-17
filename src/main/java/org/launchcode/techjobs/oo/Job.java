package org.launchcode.techjobs.oo;

import java.util.Objects;
import java.util.stream.Stream;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;



    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name =name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        if (Stream.of(name, employer, location, positionType, coreCompetency).allMatch(Objects::isNull)) { //I googled this and mostly get it
            return "OOPS! This job does not seem to exist.";
        } else {
            StringBuilder output = new StringBuilder();
            output.append(System.lineSeparator());
            output.append("ID: ").append(getId()).append(System.lineSeparator());
            output.append("Name: ").append(this.name.isEmpty() ? "Data not available" : this.getName()).append(System.lineSeparator());
            output.append("Employer: ").append(this.getEmployer().getValue().isEmpty() ? "Data not available" : this.getEmployer()).append(System.lineSeparator());
            output.append("Location: ").append(this.getLocation().getValue().isEmpty() ? "Data not available" : this.getLocation()).append(System.lineSeparator());
            output.append("Position Type: ").append(this.getPositionType().getValue().isEmpty() ? "Data not available" : this.getPositionType()).append(System.lineSeparator());
            output.append("Core Competency: ").append(this.getCoreCompetency().getValue().isEmpty() ? "Data not available" : this.getCoreCompetency()).append(System.lineSeparator());
            return output.toString();
        }
    }

}
