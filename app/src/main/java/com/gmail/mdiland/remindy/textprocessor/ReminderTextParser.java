package com.gmail.mdiland.remindy.textprocessor;

import com.gmail.mdiland.remindy.entity.Reminder;

/**
 * Created by mdiland on 2015-10-23.
 */
public interface ReminderTextParser {
    Reminder process(String text);
}
