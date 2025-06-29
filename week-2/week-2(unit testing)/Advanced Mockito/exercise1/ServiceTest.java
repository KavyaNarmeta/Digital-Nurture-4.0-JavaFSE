package com.kavya.test.MockitoMavenDemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepo = mock(Repository.class);
        when(mockRepo.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepo);
        String result = service.processData();

        System.out.println(result);
        assertEquals("Processed Mock Data", result);
    }
}
