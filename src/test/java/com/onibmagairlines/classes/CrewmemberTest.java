package com.onibmagairlines.classes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Due to the fact that method setRole in class Crewmember has been refactored to check whether given id number
of role actually exists in program, the tests ar no longer passing.
Before this refactoring tests worked properly.
 */

class CrewmemberTest {

    @Test
    void getRoleCaptain() {
        Crewmember testCaptain = new Crewmember("Jan", "Kowalski", "DAB12", 1);
        assertEquals(1, testCaptain.getRoleInt());
    }
}
