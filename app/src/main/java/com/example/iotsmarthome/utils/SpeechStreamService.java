package com.example.iotsmarthome.utils;


public class SpeechStreamService {

    private Thread recognizerThread;

    /**
     * Creates speech service.
     **/
    public SpeechStreamService() {
    }

    /**
     * Stops recognition. All listeners should receive final result if there is
     * any. Does nothing if recognition is not active.
     *
     * @return true if recognition was actually stopped
     */
    public boolean stop() {
        if (null == recognizerThread)
            return false;

        try {
            recognizerThread.interrupt();
            recognizerThread.join();
        } catch (InterruptedException e) {
            // Restore the interrupted status.
            Thread.currentThread().interrupt();
        }

        recognizerThread = null;
        return true;
    }
}
