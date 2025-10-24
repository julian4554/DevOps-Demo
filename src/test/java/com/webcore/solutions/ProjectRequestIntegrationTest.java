package com.webcore.solutions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ProjectRequestIntegrationTest {

    @Autowired
    private ProjectRequestRepository repository;

    @Test
    void testSaveAndReadProjectRequest() {
        // Arrange
        ProjectRequest request = new ProjectRequest();
        request.setName("Test User");
        request.setEmail("test@webcore.com");
        request.setDescription("Testing database connectivity with valid data");

        // Act
        repository.save(request);

        // Assert
        assertThat(repository.findById(request.getId())).isPresent();
    }
}
