package com.example.demo.entranceStage;

import com.example.demo.entranceStage.util.FlatOn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceStageService extends FlatOn {
    public List<EntranceStage> getTheFloor(Number theFlat) {
        this.setFlatNum(theFlat + "");
        this.build();

        return List.of(
                new EntranceStage(
                        1L,
                        this.getFlatNum() + "",
                        this.getHowManyFloors() + "",
                        this.getNumberOfFloor() + "",
                        this.getLowerFlat() + "",
                        this.getUpperFlat() + "",
                        this.getFlStack() + "",
                        this.getHowManyFlatsOnFloor() + "",
                        this.getNumberOfEntrance() + "",
                        this.getEntranceFlatsList()
                )
        );
    }
}



//        System.out.println(this.getNumberOfFloor());
//        System.out.println(this.getLowerFlat());
//        System.out.println(this.getUpperFlat());
//        System.out.println(this.getFlStack());
//        System.out.println(this.getHowManyFlatsOnFloor() + "кв/эт");
//        System.out.println("подъезд: " + this.getNumberOfEntrance());
//        System.out.println(this.getEntranceFlatsList());
//        System.out.println("этажей: " + this.getHowManyFloors());
//        System.out.println("кв: " + this.getFlatNum());

        /*
        const out = {
            theFlat: 413,
            floors: 9,
            theFloor: 5,
            lFlat: 397,
            hFlat: 432,
            onFloor: 1,
            flatsOnFloor: 4,
            entrance: 12,
            entranceList: [
                {lFlat: 429, flatsOnFloor: 4, hFlat: 432, floor: 9},
                {lFlat: 425, flatsOnFloor: 4, hFlat: 428, floor: 8},
                {lFlat: 421, flatsOnFloor: 4, hFlat: 424, floor: 7},
                {lFlat: 417, flatsOnFloor: 4, hFlat: 420, floor: 6},
                {lFlat: 413, flatsOnFloor: 4, hFlat: 416, floor: 5},
                {lFlat: 409, flatsOnFloor: 4, hFlat: 412, floor: 4},
                {lFlat: 405, flatsOnFloor: 4, hFlat: 408, floor: 3},
                {lFlat: 401, flatsOnFloor: 4, hFlat: 404, floor: 2},
                {lFlat: 397, flatsOnFloor: 4, hFlat: 400, floor: 1}
            ]
        }
        */