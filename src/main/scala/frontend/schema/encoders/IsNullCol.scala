package frontend.schema.encoders

import frontend.schema.{BitPosRegistry, RegisterIdx}
import util.BigBinary

import scala.io.Source
import scala.util.Try

class IsNullColEncoder[T](init_size: Int = 1
               ) (implicit bitPosRegistry: BitPosRegistry)  extends DynamicColEncoder[T] {

    register.registerIdx(init_size)
    
    def decode_locally(i: Int): T = {
        if(i == 0) {
            None.asInstanceOf[T]
        }else 1.asInstanceOf[T]
            
    }
    
    override def queries(): Set[Seq[Int]] = Set(Nil, bits)
    def encode_locally(v: T): Int = 
        v match {
            case Some(None) => 0
            case Some(y) =>
                if(y.isInstanceOf[String]){
                    val z : String = y.asInstanceOf[String].toLowerCase()
                    if(z == "" || z == "null" || z == "n/a"){
                    0
                    }else 1
                }else 1
            case _ => 0
        }
}