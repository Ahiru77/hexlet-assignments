package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
	public Task generatEnt() {
		return Instancio.of(Task.class)
			    .ignore(Select.field(Task::getId))
				.supply(Select.field(Task::getTitle), () -> faker.lorem().word())
				.supply(Select.field(Task::getDescription), () -> faker.lorem().sentence(6))
				.create();
	}
	
    @Test
    public void testShow() throws Exception {
        var task = generatEnt();
        taskRepository.save(task);

        var request = get("/tasks/" + task.getId());

        var result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
		
		assertThatJson(body).and(
		a -> a.node("title").isEqualTo(task.getTitle()),
		a -> a.node("description").isEqualTo(task.getDescription())
		);
	}    	
	
    @Test
    public void testCreate() throws Exception {
        var taskData = generatEnt();
		
        var request = post("/tasks")
		        .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(taskData));

        var result = mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andReturn();

        var task = result.getResponse().getContentAsString();
		assertThatJson(task).and(
		a -> a.node("title").isEqualTo(taskData.getTitle()),
		a -> a.node("description").isEqualTo(taskData.getDescription())
		);
	}    		
	
    @Test
    public void testUpdate() throws Exception {
        var taskData = generatEnt();
        taskRepository.save(taskData);

        var data = new HashMap<>();
        data.put("title", "So good task");

        var request = put("/tasks/" + taskData.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                 .andExpect(status().isOk());

        var task = taskRepository.findById(taskData.getId()).get();
        assertThat(task.getTitle()).isEqualTo(("So good task"));
	}    
	
    @Test
    public void testDelete() throws Exception {
        var task = generatEnt();
        taskRepository.save(task);

        var request = delete("/tasks/" + task.getId());

        var result = mockMvc.perform(request)
                .andExpect(status().isOk());

		var body = taskRepository.findById(task.getId()).orElse(null);
		assertThat(body).isNull();
	}    		
    // END
}
