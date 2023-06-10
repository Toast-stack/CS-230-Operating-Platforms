package com.gamingroom;
//Author Zachary Nicholas

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	//Variable for GameService instance
		private static GameService service;

	// FIXME: Add missing pieces to turn this class a singleton 
	//private static GameService instance = new GameService();
	
	private void GameService(){
	}
	
	public static GameService getInstance() {
		//does the GameServic exist
		if (service == null) {
			service = new GameService(); //creates new instance
			System.out.println("New Game Service created."); //tells user new instance created
		}
		else {
			//if it already exists
			System.out.println("Game Service already instantiated.");
		}
		return service;
		}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		//Creates the instance for the iterator
		Iterator<Game> gamesIterator = games.iterator();

		//Goes through the list of games
		while (gamesIterator.hasNext()) {

			//sets the local variable for game to the next item in the list
		Game gameInstance = gamesIterator.next();

		//If game found
		if (gameInstance.getName().equalsIgnoreCase(name)) {
		return gameInstance;
		}
		}

		//If game not found
		if (game == null) {
		game = new Game(nextGameId++, name);
		games.add(game);
		}

		return game;
		}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
		}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		//Game iterator
		Iterator <Game> gamesIterator = games.iterator();
		
		//goes through list of games
		while (gamesIterator.hasNext()) {
			
			//set local game to next item in list
			Game gameInstance = gamesIterator.next();
			//if game exists
			if (gameInstance.getId() == id) {
				return gameInstance;
			}
			}
		return game;
			}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		//Game iterator
		Iterator<Game> gamesIterator = games.iterator();
		
		//goes through list of games
		while (gamesIterator.hasNext()) {
			
			//set local game to next item in list
			Game gameInstance = gamesIterator.next();
			
			//if game exists
			if (gameInstance.getName().equalsIgnoreCase(name)) {
				game = gameInstance;
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
		}
		}
