package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.SubscriptionEvent

class ChannelNotificationOnSubscription(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(SubscriptionEvent::class.java, this::onSubscription)
    }

    /** Subscribe to the Subscription Event */
    private fun onSubscription(event: SubscriptionEvent) {
        val message = when {
            event.months <= 1 -> newSubscription(
                event
            )
            else -> resubscription(event)
        }
        // Send Message
        event.twitchChat.sendMessage(event.channel.name, message)
    }

    private fun newSubscription(event: SubscriptionEvent): String {
        return String.format(
            "%s has subscribed to %s!",
            event.user.name,
            event.channel.name
        )
    }

    private fun resubscription(event: SubscriptionEvent): String {
        return String.format(
            "%s has subscribed to %s in his %s month!",
            event.user.name,
            event.channel.name,
            event.months
        )
    }

}
