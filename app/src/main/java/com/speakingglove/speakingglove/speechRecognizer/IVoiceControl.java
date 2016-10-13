package com.speakingglove.speakingglove.speechRecognizer;

/**
 * This interface is used to retrieve the voice commands and restart the listenting service
 */
public interface IVoiceControl {
    /**
     * This will be executed when a voice command was found
     * @param voiceCommands
     */
    public abstract void processVoiceCommands(String... voiceCommands);

    /**
     * This will be executed after a voice command was processed to keep the recognition service activated
     */
    public void restartListeningService();

    public void finish();
}
