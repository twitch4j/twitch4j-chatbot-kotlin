package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.simple.SimpleEventHandler
import com.github.twitch4j.chat.events.channel.DonationEvent

class ChannelNotificationOnDonation(eventHandler: SimpleEventHandler) {
    init {
        eventHandler.onEvent(DonationEvent::class.java, this::onDonation)
    }

    /** Subscribe to the Donation Event */
    private fun onDonation(event: DonationEvent) {
        val message = String.format(
            "%s just donated %s using %s!",
            event.user.name,
            event.amount,
            event.source
        )

        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
