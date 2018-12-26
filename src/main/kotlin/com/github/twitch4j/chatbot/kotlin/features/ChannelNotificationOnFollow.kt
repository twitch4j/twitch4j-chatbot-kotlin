package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.annotation.EventSubscriber
import com.github.twitch4j.chat.events.channel.FollowEvent

object ChannelNotificationOnFollow {

    /** Subscribe to the Follow Event */
    @EventSubscriber
    fun onFollow(event: FollowEvent) {
        val message = String.format(
            "%s is now following %s!",
            event.user.name,
            event.channel.name
        )

        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
