package frontend
package schema
import frontend.schema.encoders.{ColEncoder, MemCol, NatCol, IsNullColEncoder}
import util._
import util.BigBinaryTools._
import breeze.io.CSVReader
import java.io._


abstract class TimeSeriesSchema extends Schema {
    
    override def n_bits: Int = bitPosRegistry.n_bits

    implicit val bitPosRegistry = new BitPosRegistry
    val columns = collection.mutable.Map[String, ColEncoder[_]]()
    val columnTimeLabel : String = "Time"
    def columnList = columns.toList

    override  def read(filename: String, measure_key: Option[String] = None, map_value : Object => Long = _.asInstanceOf[Long]
          ): Seq[(BigBinary, Long)] = {

    val items = {
      if(filename.endsWith("json"))
        JsonReader.read(filename)
      else if(filename.endsWith("csv")){

        val csv = Profiler("CSVRead"){CSVReader.read(new FileReader(filename))}
        val header = csv.head
        val rows = Profiler("AddingColNames"){csv.tail.map(vs => header.zip(vs).toMap)}
        rows
      } else
        throw new UnsupportedOperationException("Only CSV or JSON supported")
    }
    items.zip(Range(0, items.size)).map(l => (encode_tuple(List((columnTimeLabel, l._2)) ++ l._1.toList), 1L))
     
  }

}

