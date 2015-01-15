package org.springframework.social.betaseries.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.betaseries.api.Show.SeasonDetail;
import org.springframework.social.betaseries.api.Show.UserDetail;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesMemberSingleObject;
import org.springframework.social.betaseries.api.impl.json.BetaSeriesModule;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EqualityObjectModelTest {
	private static ObjectMapper mapper;
	private static List<Show> shows;
	@BeforeClass
	public static void setUpOnce() {
		mapper = new ObjectMapper().registerModule(new BetaSeriesModule());
		shows = new ArrayList<Show>();
		
		try {
			shows = mapper.readValue(jsonResource("members-infos").getInputStream(), BetaSeriesMemberSingleObject.class).getObject().getShows();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void showNotEqualTest() {		
		Show show1 = shows.get(0);
		Show show2 = shows.get(1);		
		assertNotEquals(show1, show2);
	}
	
	@Test
	public void showSeasonDetailNotEqual() {
		SeasonDetail d1 = shows.get(0).getSeasonsDetails().get(0);
		SeasonDetail d2 = shows.get(0).getSeasonsDetails().get(1);
		assertNotEquals(d1, d2);
	}
	
	@Test
	public void showUserDetailNotEqual() {
		UserDetail u1 = shows.get(0).getUserDetail();
		UserDetail u2 = shows.get(1).getUserDetail();
		assertNotEquals(u1, u2);
	}
	
	@Test
	public void showEqualTest() {		
		Show show1 = shows.get(0);
		Show show2 = shows.get(0);		
		assertCommonEquality(show1, show2);
	}
	
	@Test
	public void showSeasonDetailEqual() {
		SeasonDetail d1 = shows.get(0).getSeasonsDetails().get(0);
		SeasonDetail d2 = shows.get(0).getSeasonsDetails().get(0);
		assertCommonEquality(d1, d2);
	}
	
	@Test
	public void showUserDetailEqual() {
		UserDetail u1 = shows.get(0).getUserDetail();
		UserDetail u2 = shows.get(0).getUserDetail();
		assertCommonEquality(u1, u2);
	}
	
	@Test
	public void untializeShowEqualTest() {		
		Show show1 = new Show();
		Show show2 = new Show();		
		assertCommonEquality(show1, show2);
	}
	
	@Test
	public void untializeShowSeasonDetailEqual() {
		SeasonDetail d1 = new SeasonDetail(0,0);
		SeasonDetail d2 = new SeasonDetail(0,0);
		assertCommonEquality(d1, d2);
	}
	
	@Test
	public void untializeShowUserDetailEqual() {
		UserDetail u1 = shows.get(0).getUserDetail();
		UserDetail u2 = shows.get(0).getUserDetail();
		assertCommonEquality(u1, u2);
	}
	
	@Test
	public void differentInstanceEqual() {
		UserDetail u1 = shows.get(0).getUserDetail();
		SeasonDetail d2 = shows.get(0).getSeasonsDetails().get(0);
		
		assertCommonNotEquality(u1, d2);
		assertCommonNotEquality(d2, u1);		
	}
	
	private void assertCommonEquality(Object obj1, Object obj2) {
		assertEquals(obj1, obj2);
		assertEquals(obj1.toString(), obj2.toString());
		assertEquals(obj1.hashCode(), obj2.hashCode());
	}
	
	private void assertCommonNotEquality(Object obj1, Object obj2) {
		assertNotEquals(obj1, obj2);
		assertNotEquals(obj1.toString(), obj2.toString());
		assertNotEquals(obj1.hashCode(), obj2.hashCode());
	}
	
	private static Resource jsonResource(String file) {
		return new ClassPathResource(file + ".json", EqualityObjectModelTest.class);
	}
}
