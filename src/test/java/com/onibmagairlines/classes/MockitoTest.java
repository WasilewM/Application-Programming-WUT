package com.onibmagairlines.classes;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoTest {

    @Test
    void getMockedRoleCaptain() {
        Crewmember testCaptainMock = mock(Crewmember.class);
        when(testCaptainMock.getRoleInt()).thenReturn(1);
        assertEquals(1, testCaptainMock.getRoleInt());
    }
}
