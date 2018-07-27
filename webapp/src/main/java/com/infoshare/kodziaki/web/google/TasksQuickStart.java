package com.infoshare.kodziaki.web.google;

        import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
        import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
        import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
        import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
        import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
        import com.google.api.client.http.javanet.NetHttpTransport;
        import com.google.api.client.json.JsonFactory;
        import com.google.api.client.json.jackson2.JacksonFactory;
        import com.google.api.client.util.store.FileDataStoreFactory;
        import com.google.api.services.tasks.Tasks;
        import com.google.api.services.tasks.TasksScopes;
        import com.google.api.services.tasks.model.TaskList;
        import com.google.api.services.tasks.model.TaskLists;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.security.GeneralSecurityException;
        import java.util.Collections;
        import java.util.List;

public class TasksQuickstart {
    private static final String APPLICATION_NAME = "appPartments";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";


    private static final List<String> SCOPES = Collections.singletonList(TasksScopes.TASKS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = TasksQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Tasks service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Print the first 10 task lists.
        TaskLists result = service.tasklists().list()
                .setMaxResults(10L)
                .execute();
        List<TaskList> taskLists = result.getItems();
        if (taskLists == null || taskLists.isEmpty()) {
            System.out.println("No task lists found.");
        } else {
            System.out.println("Task lists:");
            for (TaskList tasklist : taskLists) {
                System.out.printf("%s (%s)\n", tasklist.getTitle(), tasklist.getId());
            }
        }
    }
}