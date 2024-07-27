@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package com.jetbrains.rider.plugins.plugintemplate.model

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.time.Duration
import kotlin.reflect.KClass
import kotlin.jvm.JvmStatic



/**
 * #### Generated from [RdSampleModel.kt:11]
 */
class RdSampleModel private constructor(
    private val _myCall: RdCall<RdCallRequest, RdCallResponse>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            val classLoader = javaClass.classLoader
            serializers.register(LazyCompanionMarshaller(RdId(-3835427627873167508), classLoader, "com.jetbrains.rider.plugins.plugintemplate.model.RdCallRequest"))
            serializers.register(LazyCompanionMarshaller(RdId(-8217792021757949180), classLoader, "com.jetbrains.rider.plugins.plugintemplate.model.RdCallResponse"))
        }
        
        
        
        
        
        const val serializationHash = -3003694560678971247L
        
    }
    override val serializersOwner: ISerializersOwner get() = RdSampleModel
    override val serializationHash: Long get() = RdSampleModel.serializationHash
    
    //fields
    
    /**
     * This is an example protocol call.
     */
    val myCall: IRdCall<RdCallRequest, RdCallResponse> get() = _myCall
    //methods
    //initializer
    init {
        bindableChildren.add("myCall" to _myCall)
    }
    
    //secondary constructor
    internal constructor(
    ) : this(
        RdCall<RdCallRequest, RdCallResponse>(RdCallRequest, RdCallResponse)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("RdSampleModel (")
        printer.indent {
            print("myCall = "); _myCall.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): RdSampleModel   {
        return RdSampleModel(
            _myCall.deepClonePolymorphic()
        )
    }
    //contexts
    //threading
    override val extThreading: ExtThreadingKind get() = ExtThreadingKind.Default
}
val com.jetbrains.rd.ide.model.Solution.rdSampleModel get() = getOrCreateExtension("rdSampleModel", ::RdSampleModel)



/**
 * #### Generated from [RdSampleModel.kt:12]
 */
data class RdCallRequest (
    val myField: String
) : IPrintable {
    //companion
    
    companion object : IMarshaller<RdCallRequest> {
        override val _type: KClass<RdCallRequest> = RdCallRequest::class
        override val id: RdId get() = RdId(-3835427627873167508)
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): RdCallRequest  {
            val myField = buffer.readString()
            return RdCallRequest(myField)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: RdCallRequest)  {
            buffer.writeString(value.myField)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as RdCallRequest
        
        if (myField != other.myField) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + myField.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("RdCallRequest (")
        printer.indent {
            print("myField = "); myField.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}


/**
 * #### Generated from [RdSampleModel.kt:16]
 */
data class RdCallResponse (
    val myResult: Int
) : IPrintable {
    //companion
    
    companion object : IMarshaller<RdCallResponse> {
        override val _type: KClass<RdCallResponse> = RdCallResponse::class
        override val id: RdId get() = RdId(-8217792021757949180)
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): RdCallResponse  {
            val myResult = buffer.readInt()
            return RdCallResponse(myResult)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: RdCallResponse)  {
            buffer.writeInt(value.myResult)
        }
        
        
    }
    //fields
    //methods
    //initializer
    //secondary constructor
    //equals trait
    override fun equals(other: Any?): Boolean  {
        if (this === other) return true
        if (other == null || other::class != this::class) return false
        
        other as RdCallResponse
        
        if (myResult != other.myResult) return false
        
        return true
    }
    //hash code trait
    override fun hashCode(): Int  {
        var __r = 0
        __r = __r*31 + myResult.hashCode()
        return __r
    }
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("RdCallResponse (")
        printer.indent {
            print("myResult = "); myResult.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    //contexts
    //threading
}
