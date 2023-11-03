package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;



public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getEmployer() instanceof Employer); //ask about null
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(),"ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(),"Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Fry Cook", new Employer("Krusty Krab"), new Location("Bikini Bottom"), new PositionType("Cook"), new CoreCompetency("Jellyfishing"));
        Job jobTwo = new Job("Fry Cook", new Employer("Krusty Krab"), new Location("Bikini Bottom"), new PositionType("Cook"), new CoreCompetency("Jellyfishing"));
        //assertFalse(jobOne.equals(jobTwo)); - original test but gave yellow squiggle
        assertNotEquals(jobOne, jobTwo);
    }

    //Task 5 unit tests below

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobOne = new Job("Fry Cook", new Employer("Krusty Krab"), new Location("Bikini Bottom"), new PositionType("Cook"), new CoreCompetency("Jellyfishing"));
        String firstCharacter = String.valueOf(jobOne.toString().charAt(0));
        String lastCharacter = String.valueOf(jobOne.toString().charAt(jobOne.toString().length()-1));
        assertEquals(firstCharacter, lineSeparator());
        assertEquals(lastCharacter, lineSeparator());
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobOne = new Job("Fry Cook", new Employer("Krusty Krab"), new Location("Bikini Bottom"), new PositionType("Cook"), new CoreCompetency("Jellyfishing"));
        String jobOneString = jobOne.toString();
        String JobOneExpected = System.lineSeparator() +
                "ID: " + jobOne.getId() + System.lineSeparator() +
                "Name: " + jobOne.getName() + System.lineSeparator() +
                "Employer: " + jobOne.getEmployer() + System.lineSeparator() +
                "Location: " + jobOne.getLocation() + System.lineSeparator() +
                "Position Type: " + jobOne.getPositionType() + System.lineSeparator() +
                "Core Competency: " + jobOne.getCoreCompetency() + System.lineSeparator() +
                System.lineSeparator();
        assertEquals(jobOneString, JobOneExpected);
        //magic code pls work
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("Fry Cook", new Employer("Krusty Krab"), new Location(""), new PositionType("Cook"), new CoreCompetency(""));
        String jobOneExpected = System.lineSeparator() +
                "ID: " + jobOne.getId() + System.lineSeparator() +
                "Name: " + jobOne.getName() + System.lineSeparator() +
                "Employer: " + jobOne.getEmployer() + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: " + jobOne.getPositionType() + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();
        assertEquals(jobOneExpected,
                jobOne.toString());

    }

    @Test
    public void testToStringOnlyHasIdData() {
        Job jobOne = new Job();
        assertEquals(jobOne.toString(), "OOPS! This job does not seem to exist.");
    }

}
