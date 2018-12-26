package com.github.twitch4j.chatbot.kotlin.features

import com.github.philippheuer.events4j.annotation.EventSubscriber
import com.github.twitch4j.chat.events.channel.DonationEvent

object ChannelNotificationOnDonation {

    /** Subscribe to the Donation Event */
    @EventSubscriber
    fun onDonation(event: DonationEvent) {
        val message = String.format(
            "%s just donated %s using %s!",
            event.user.name,
            event.amount,
            event.source
        )

        event.twitchChat.sendMessage(event.channel.name, message)
    }

}
