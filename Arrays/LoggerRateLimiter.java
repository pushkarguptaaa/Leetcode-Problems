package Arrays;

import java.util.HashMap;

public class LoggerRateLimiter {
    private final HashMap<String, Integer> messageTimestamps; // HashMap to store message and its last logged timestamp
    private final int timeLimit; // Time limit in seconds

    public LoggerRateLimiter(int timeLimit) {
        this.messageTimestamps = new HashMap<>();
        this.timeLimit = timeLimit;
    }

    /**
     * Logs a message if it's allowed within the rate limit.
     * @param timestamp The current timestamp in seconds.
     * @param message The message to be logged.
     * @return true if the message is logged, false otherwise.
     */
    public boolean shouldLogMessage(int timestamp, String message) {
        if (messageTimestamps.containsKey(message)) {
            int lastLoggedTime = messageTimestamps.get(message);

            // If the message was logged before the time limit expired, reject it
            if (timestamp - lastLoggedTime < timeLimit) {
                return false;
            }
        }

        // Log the message and update its timestamp
        messageTimestamps.put(message, timestamp);
        return true;
    }
}

    
