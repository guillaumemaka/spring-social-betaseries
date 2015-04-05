/**
 * Copyright 2015 [name of copyright owner]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.betaseries.api.impl.json;

import org.springframework.social.betaseries.api.BSOptions;
import org.springframework.social.betaseries.api.BSUser;
import org.springframework.social.betaseries.api.Badge;
import org.springframework.social.betaseries.api.BetaSeriesObject;
import org.springframework.social.betaseries.api.Character;
import org.springframework.social.betaseries.api.Comment;
import org.springframework.social.betaseries.api.Episode;
import org.springframework.social.betaseries.api.Event;
import org.springframework.social.betaseries.api.Friend;
import org.springframework.social.betaseries.api.Member;
import org.springframework.social.betaseries.api.MemberOptions;
import org.springframework.social.betaseries.api.MemberStats;
import org.springframework.social.betaseries.api.Message;
import org.springframework.social.betaseries.api.Movie;
import org.springframework.social.betaseries.api.Note;
import org.springframework.social.betaseries.api.Notification;
import org.springframework.social.betaseries.api.NotificationList;
import org.springframework.social.betaseries.api.Picture;
import org.springframework.social.betaseries.api.Recommendation;
import org.springframework.social.betaseries.api.Show;
import org.springframework.social.betaseries.api.SimilarShow;
import org.springframework.social.betaseries.api.Subtitle;
import org.springframework.social.betaseries.api.SubtitleSource;
import org.springframework.social.betaseries.api.UnseenEpisode;
import org.springframework.social.betaseries.api.Video;

import com.fasterxml.jackson.databind.module.SimpleModule;

// TODO: Auto-generated Javadoc
/**
 * The Class BetaSeriesModule.
 * 
 * @author Guillaume Maka
 */
public class BetaSeriesModule extends SimpleModule {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new beta series module.
	 */
	public BetaSeriesModule() {
		super("BetaSeriesModule");		
	}
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.module.SimpleModule#setupModule(com.fasterxml.jackson.databind.Module.SetupContext)
	 */
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(BetaSeriesObject.class, BetaSeriesObjectMixin.class);				
		context.setMixInAnnotations(Comment.class, CommentMixin.class);
		context.setMixInAnnotations(Show.class, ShowMixin.class);
		context.setMixInAnnotations(Show.SeasonDetail.class, ShowMixin.SeasonDetailMixin.class);
		context.setMixInAnnotations(Show.UserDetail.class, ShowMixin.UserDetailMixin.class);
		context.setMixInAnnotations(SimilarShow.class, SimilarShowMixin.class);
		context.setMixInAnnotations(Character.class, CharacterMixin.class);
		context.setMixInAnnotations(Member.class, MemberMixin.class);
		context.setMixInAnnotations(MemberOptions.class, MemberOptionsMixin.class);
		context.setMixInAnnotations(MemberStats.class, MemberStatsMixin.class);
		context.setMixInAnnotations(Note.class, NoteMixin.class);
		context.setMixInAnnotations(Friend.class, FriendMixin.class);
		context.setMixInAnnotations(Episode.class, EpisodeMixin.class);
		context.setMixInAnnotations(UnseenEpisode.class, UnseenEpisodeMixin.class);
		context.setMixInAnnotations(Badge.class, BadgeMixin.class);
		context.setMixInAnnotations(Movie.class, MovieMixin.class);
		context.setMixInAnnotations(Movie.UserDetail.class, MovieMixin.UserDetailMixin.class);
		context.setMixInAnnotations(Movie.SummarizedMovie.class, MovieMixin.SummarizedMovieMixin.class);
		context.setMixInAnnotations(Notification.class, NotificationMixin.class);
		context.setMixInAnnotations(NotificationList.class, NotificationListMixin.class);
		context.setMixInAnnotations(SubtitleSource.class, SubtitleSourceMixin.class);
		context.setMixInAnnotations(Subtitle.class, SubtitleMixin.class);
		context.setMixInAnnotations(Subtitle.EmbededEpisode.class, SubtitleMixin.EmbededEpisodeMixin.class);
		context.setMixInAnnotations(BSOptions.class, BSOptionsMixin.class);
		context.setMixInAnnotations(Video.class, VideoMixin.class);
		context.setMixInAnnotations(Picture.class, PictureMixin.class);
		context.setMixInAnnotations(BSUser.class, BSUserMixin.class);
		context.setMixInAnnotations(Recommendation.class, RecommendationMixin.class);
		context.setMixInAnnotations(Message.class, MessageMixin.class);
		context.setMixInAnnotations(Event.class, EventMixin.class);
	}	
}
