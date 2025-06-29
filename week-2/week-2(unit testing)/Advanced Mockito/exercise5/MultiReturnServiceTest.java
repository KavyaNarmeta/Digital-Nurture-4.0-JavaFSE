package com.kavya.test.MockitoMavenDemo;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MultiReturnServiceTest {
    @Test
    public void testServiceWithMultipleReturnValues() {
        Repository mockRepo = mock(Repository.class);
        when(mockRepo.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        Service service = new Service(mockRepo);

        String first = service.processData();
        String second = service.processData();

        System.out.println(first);
        System.out.println(second);
        assertEquals("Processed First Mock Data", first);
        assertEquals("Processed Second Mock Data", second);
    }
}
