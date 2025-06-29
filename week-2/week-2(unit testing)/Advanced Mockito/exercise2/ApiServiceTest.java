package com.kavya.test.MockitoMavenDemo;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApiServiceTest {
    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockClient);
        String result = apiService.fetchData();

        System.out.println(result);
        assertEquals("Fetched Mock Response", result);
    }
}
