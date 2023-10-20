package org.launchcode.techjobs.oo;

import org.junit.Test;
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
}
