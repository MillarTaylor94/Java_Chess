package com.game.chess.board;


import com.game.chess.piece.piece;

import java.util.HashMap;
import java.util.Map;

//Tile class, piece container for  Game Board.
public abstract class Tile {


    //----------------------------------------------------------Variables-------------------------------------------------------------------
    //Tile location(Game Board)
    private final int coordinate;

    //Map of immutable empty Tiles
    //each is mapped to a board location
     private static final Map<Integer, emptyTile> EMPTY_TILES= createAllEmptyTiles();

    //basic constructor
    private Tile(int coordinate){
        this.coordinate=coordinate;
    }


//----------------------------------------------------------Methods-------------------------------------------------------------------

    //Method: isOccupied()
    //Returns: Boolean, True:occupied false:empty
    //Purpose:determines if space is occupied/empty
    public abstract boolean isOccupied();
    //Method: getPiece()
    //Returns: Piece Located at tile.
    public abstract piece getPiece();


    //Method: createAllEmptyTiles()
    //Returns: Map of empty tiles.
    //Purpose:Creates a map of all empty tiles, mapped to their respective board coordinate.
    private static Map<Integer, emptyTile> createAllEmptyTiles(){
        final Map<Integer, emptyTile> emptyTileMap=new HashMap<>();
        for(int i=0; i<64;i++)
            emptyTileMap.put(i, new emptyTile(i));

        return emptyTileMap;


    }

    //Method createTile
    //Returns new tile
    //Purpose:Tile Factory returns empty or occupied tile,
static Tile CreateTile(final int coordinate, final piece piece){

    if(piece==null)
        return EMPTY_TILES.get(coordinate);
        else
            return new occupiedTile(coordinate,piece);
    }



    //---------------------------------------------------------Empty Tile-------------------------------------------------------------------
private static final class emptyTile extends Tile{



    public emptyTile(int coordinate) {
        super(coordinate);
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public piece getPiece() {
        return null;
    }

}

//----------------------------------------------------------Occupied Tile-------------------------------------------------------------------
public  static final class occupiedTile extends Tile{


        private final piece Piece;
        private occupiedTile(int coordinate, piece Piece){
   super(coordinate);
   this.Piece=Piece;
        }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public piece getPiece() {
        return this.Piece;
    }
}


}
