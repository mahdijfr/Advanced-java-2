import connection.Connection;
import models.SetKeyMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import server.Server;
import server.ConnectionHandler;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CacheSampleTest {
    private final String ip = "127.0.0.1";
    private final int port = 6379;

    @Before
    public void initializeServer() throws InterruptedException {
        (new Server()).start(this.port);
        Thread.sleep(100);
    }

    @After
    public void waitForDisconnections() throws InterruptedException {
        Thread.sleep(200);
    }

    @Test
    public void testConnectAndSetKeySingleUser() throws InterruptedException {
                Connection user1 = new Connection("user1", this.ip, this.port);
        Thread.sleep(200);
        assertEquals(new HashMap<>(), ConnectionHandler.cache.get("user1"));

        user1.sendMessage(new SetKeyMessage("a", "b"));
        Thread.sleep(100);
        assertEquals("b", ConnectionHandler.cache.get("user1").get("a"));

        user1.sendMessage(new SetKeyMessage("a", "b"));
        Thread.sleep(100);
        assertEquals("b", ConnectionHandler.cache.get("user1").get("a"));

        user1.sendMessage(new SetKeyMessage("a", "c"));
        Thread.sleep(100);
        assertEquals("c", ConnectionHandler.cache.get("user1").get("a"));

        user1.sendMessage(new SetKeyMessage("asjkldfbsdlfjb", "sd3f21sd"));
        Thread.sleep(100);
        assertEquals("sd3f21sd", ConnectionHandler.cache.get("user1").get("asjkldfbsdlfjb"));

        user1.disconnect();
    }
}