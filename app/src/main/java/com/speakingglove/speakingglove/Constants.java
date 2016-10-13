package com.speakingglove.speakingglove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by menaka on 10/13/16.
 */
public class Constants {
    public static final String EVENT_LISTENER_STARTED = "xxStartedxx";
    public static final String EVENT_LISTENER_FINISHED = "xxFinishedxx";
    public static final String EVENT_LISTENER_ONGOING = "xxOngoingxx";

    static String[] words = {"Hello", "Fine", "I'm", "hungry", "help", "me"};
    public static List<String> wordList = new ArrayList<>(Arrays.asList(words));

}
