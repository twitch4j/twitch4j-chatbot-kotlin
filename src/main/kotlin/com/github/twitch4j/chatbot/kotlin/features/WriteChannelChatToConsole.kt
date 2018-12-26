package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.annotation.EventSubscriber
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent

object WriteChannelChatToConsole {

    /** Subscribe to the ChannelMessage Event and write the output to the console */
    @EventSubscriber
    fun onChannelMessage(event: ChannelMessageEvent) {
        System.out.printf(
            "Channel [%s] - User[%s] - Message [%s]%n",
            event.channel.name,
            event.user.name,
            event.message
        )
    }

}
