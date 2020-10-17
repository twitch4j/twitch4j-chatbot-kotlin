package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent

class WriteChannelChatToConsole(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(ChannelMessageEvent::class.java, this::onChannelMessage)
    }

    /** Subscribe to the ChannelMessage Event and write the output to the console */
    private fun onChannelMessage(event: ChannelMessageEvent) {
        System.out.printf(
            "Channel [%s] - User[%s] - Message [%s]%n",
            event.channel.name,
            event.user.name,
            event.message
        )
    }

}
