package dictionary.bot.operations;

import com.google.gson.annotations.SerializedName;
import dictionary.bot.OutputBody;

import java.util.List;

/**
 * Created by harshit on 25/1/16.
 * Sample response:
 * {
 "response_code": 200,
 "total": 1,
 "train": [
 {
 "no": 1,
 "name": "RAPTI SAGAR EXP",
 "number": "12511",
 "src_departure_time": "06:35",
 "dest_arrival_time": "03:50",
 "from": {
 "name": "GORAKHPUR JN",
 "code": "GKP"
 },
 "to": {
 "name": "NAGPUR",
 "code": "NGP"
 },
 "classes": [
 {
 "class-code": "FC",
 "available": "N"
 },
 {
 "class-code": "3E",
 "available": "N"
 },
 {
 "class-code": "CC",
 "available": "N"
 },
 {
 "class-code": "SL",
 "available": "Y"
 },
 {
 "class-code": "2S",
 "available": "N"
 },
 {
 "class-code": "2A",
 "available": "Y"
 },
 {
 "class-code": "3A",
 "available": "Y"
 },
 {
 "class-code": "1A",
 "available": "N"
 }
 ],
 "days": [
 {
 "day-code": "MON",
 "runs": "N"
 },
 {
 "day-code": "TUE",
 "runs": "N"
 },
 {
 "day-code": "WED",
 "runs": "N"
 },
 {
 "day-code": "THU",
 "runs": "Y"
 },
 {
 "day-code": "FRI",
 "runs": "Y"
 },
 {
 "day-code": "SAT",
 "runs": "N"
 },
 {
 "day-code": "SUN",
 "runs": "Y"
 }
 ]
 }
 ]
 }
 */
public class Trains implements OutputBody {
    private static final long serialVersionUID = 2013787763405683980L;
    private int total;
    private List<Train> train;

    @Override
    public String toString() {
        return "Trains{" +
                "total=" + total +
                ", train=" + train +
                '}';
    }

    @Override
    public String toUserString() {
        return toString();
    }

    private class Train {
        private int number;
        private String name;
        private String src_departure_time;
        private String dest_arrival_time;
        private Station from;
        private Station to;
        private List<Classes> classes;
        private List<Days> days;

        @Override
        public String toString() {
            return "Train{" +
                    "number=" + number +
                    ", name='" + name + '\'' +
                    ", src_departure_time='" + src_departure_time + '\'' +
                    ", dest_arrival_time='" + dest_arrival_time + '\'' +
                    ", from=" + from +
                    ", to=" + to +
                    ", classes=" + classes +
                    ", days=" + days +
                    '}';
        }
    }

    private class Classes {
        @SerializedName("class-code")
        private String classCode;
        private String available;

        public String getClassCode() {
            return classCode;
        }

        public void setClassCode(String classCode) {
            this.classCode = classCode;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "Classes{" +
                    "classCode='" + classCode + '\'' +
                    ", available='" + available + '\'' +
                    '}';
        }
    }

    private class Days {
        @SerializedName("day-code")
        private String dayCode;
        private String runs;

        public String getRuns() {
            return runs;
        }

        public void setRuns(String runs) {
            this.runs = runs;
        }

        public String getDayCode() {
            return dayCode;
        }

        public void setDayCode(String dayCode) {
            this.dayCode = dayCode;
        }

        @Override
        public String toString() {
            return "Days{" +
                    "dayCode='" + dayCode + '\'' +
                    ", runs='" + runs + '\'' +
                    '}';
        }
    }
    private class Station {
        private String code;
        private String name;

        @Override
        public String toString() {
            return "Station{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
