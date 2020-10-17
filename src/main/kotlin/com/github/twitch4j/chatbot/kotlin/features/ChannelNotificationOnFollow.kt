package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.FollowEvent

class ChannelNotificationOnFollow(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(FollowEvent::class.java, this::onFollow)
    }

    /** Subscribe to the Follow Event */
    private fun onFollow(event: FollowEvent) {
        val message = String.format(
            "%s is now following %s!",
            event.user.name,
            event.channel.name
        )
        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
