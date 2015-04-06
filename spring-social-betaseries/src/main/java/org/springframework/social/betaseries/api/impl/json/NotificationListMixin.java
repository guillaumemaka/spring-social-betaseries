package org.springframework.social.betaseries.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonDeserialize(using=NotificationsDeserializer.class)
public class NotificationListMixin {

}
