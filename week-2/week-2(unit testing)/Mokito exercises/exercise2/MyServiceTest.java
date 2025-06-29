package com.kavya.test.MockitoMavenDemo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        
        ExternalApi mockApi = mock(ExternalApi.class);

       
        MyService service = new MyService(mockApi);
        service.fetchData();

     
        verify(mockApi).getData(); 
    }
}
