// Autogenerated from Pigeon (v10.1.6), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.morbit.tencent_map

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  if (exception is FlutterError) {
    return listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    return listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

enum class MapType(val raw: Int) {
  NORMAL(0),
  SATELLITE(1),
  DARK(2);

  companion object {
    fun ofRaw(raw: Int): MapType? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/**
 * 定位模式
 *
 * 在地图的各种应用场景中，用户对定位点展示时也希望地图能跟随定位点旋转、移动等多种行为
 */
enum class UserLocationType(val raw: Int) {
  /** 跟踪用户的位置与方向更新，默认是此种类型 */
  TRACKINGLOCATIONROTATE(0),
  /** 追踪用户的位置更新 */
  TRACKINGLOCATION(1),
  /** 跟踪用户的位置与方向更新，并移动到地图中心（Android only, Android default） */
  TRACKINGLOCATIONROTATECENTER(2),
  /** 不追踪用户的位置与方向更新（iOS only） */
  NOTRACKING(3),
  /** 跟踪用户的位置与方向更新，并地图依照用户方向旋转（Android only） */
  TRACKINGROTATE(4);

  companion object {
    fun ofRaw(raw: Int): UserLocationType? {
      return values().firstOrNull { it.raw == raw }
    }
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class Anchor (
  val x: Double,
  val y: Double

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): Anchor {
      val x = list[0] as Double
      val y = list[1] as Double
      return Anchor(x, y)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      x,
      y,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class Position (
  val latitude: Double,
  val longitude: Double

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): Position {
      val latitude = list[0] as Double
      val longitude = list[1] as Double
      return Position(latitude, longitude)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      latitude,
      longitude,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class Location (
  val position: Position,
  val bearing: Double? = null,
  val accuracy: Double? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): Location {
      val position = Position.fromList(list[0] as List<Any?>)
      val bearing = list[1] as Double?
      val accuracy = list[2] as Double?
      return Location(position, bearing, accuracy)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      position.toList(),
      bearing,
      accuracy,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class MapPoi (
  val name: String,
  val position: Position

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): MapPoi {
      val name = list[0] as String
      val position = Position.fromList(list[1] as List<Any?>)
      return MapPoi(name, position)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      name,
      position.toList(),
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class CameraPosition (
  val target: Position? = null,
  val bearing: Double? = null,
  val tilt: Double? = null,
  val zoom: Double? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): CameraPosition {
      val target: Position? = (list[0] as List<Any?>?)?.let {
        Position.fromList(it)
      }
      val bearing = list[1] as Double?
      val tilt = list[2] as Double?
      val zoom = list[3] as Double?
      return CameraPosition(target, bearing, tilt, zoom)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      target?.toList(),
      bearing,
      tilt,
      zoom,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class MarkerOptions (
  val position: Position,
  val alpha: Double? = null,
  val rotation: Double? = null,
  val zIndex: Long? = null,
  val flat: Boolean? = null,
  val draggable: Boolean? = null,
  val icon: Bitmap? = null,
  val anchor: Anchor? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): MarkerOptions {
      val position = Position.fromList(list[0] as List<Any?>)
      val alpha = list[1] as Double?
      val rotation = list[2] as Double?
      val zIndex = list[3].let { if (it is Int) it.toLong() else it as Long? }
      val flat = list[4] as Boolean?
      val draggable = list[5] as Boolean?
      val icon: Bitmap? = (list[6] as List<Any?>?)?.let {
        Bitmap.fromList(it)
      }
      val anchor: Anchor? = (list[7] as List<Any?>?)?.let {
        Anchor.fromList(it)
      }
      return MarkerOptions(position, alpha, rotation, zIndex, flat, draggable, icon, anchor)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      position.toList(),
      alpha,
      rotation,
      zIndex,
      flat,
      draggable,
      icon?.toList(),
      anchor?.toList(),
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class PolylineOptions (
  val points: List<Position?>? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): PolylineOptions {
      val points = list[0] as List<Position?>?
      return PolylineOptions(points)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      points,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class Bitmap (
  val asset: String? = null,
  val bytes: ByteArray? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): Bitmap {
      val asset = list[0] as String?
      val bytes = list[1] as ByteArray?
      return Bitmap(asset, bytes)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      asset,
      bytes,
    )
  }
}
/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface TencentMapSdkApi {
  fun initSdk(iosApiKey: String?, agreePrivacy: Boolean)

  companion object {
    /** The codec used by TencentMapSdkApi. */
    val codec: MessageCodec<Any?> by lazy {
      StandardMessageCodec()
    }
    /** Sets up an instance of `TencentMapSdkApi` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: TencentMapSdkApi?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapSdkApi.initSdk", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val iosApiKeyArg = args[0] as String?
            val agreePrivacyArg = args[1] as Boolean
            var wrapped: List<Any?>
            try {
              api.initSdk(iosApiKeyArg, agreePrivacyArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object TencentMapApiCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Anchor.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Bitmap.fromList(it)
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          CameraPosition.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Location.fromList(it)
        }
      }
      132.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          MarkerOptions.fromList(it)
        }
      }
      133.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          PolylineOptions.fromList(it)
        }
      }
      134.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Position.fromList(it)
        }
      }
      135.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Position.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is Anchor -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is Bitmap -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      is CameraPosition -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is Location -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      is MarkerOptions -> {
        stream.write(132)
        writeValue(stream, value.toList())
      }
      is PolylineOptions -> {
        stream.write(133)
        writeValue(stream, value.toList())
      }
      is Position -> {
        stream.write(134)
        writeValue(stream, value.toList())
      }
      is Position -> {
        stream.write(135)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface TencentMapApi {
  fun setMapType(type: MapType)
  fun setCompassEnabled(enabled: Boolean)
  fun setScaleControlsEnabled(enabled: Boolean)
  fun setRotateGesturesEnabled(enabled: Boolean)
  fun setScrollGesturesEnabled(enabled: Boolean)
  fun setZoomGesturesEnabled(enabled: Boolean)
  fun setTiltGesturesEnabled(enabled: Boolean)
  fun setIndoorViewEnabled(enabled: Boolean)
  fun setTrafficEnabled(enabled: Boolean)
  fun setBuildingsEnabled(enabled: Boolean)
  fun setMyLocationButtonEnabled(enabled: Boolean)
  fun setMyLocationEnabled(enabled: Boolean)
  fun setMyLocation(location: Location)
  fun setUserLocationType(type: UserLocationType)
  fun moveCamera(position: CameraPosition, duration: Long)
  fun addMarker(options: MarkerOptions): String
  fun addPolyline(options: PolylineOptions): String
  fun pause()
  fun resume()
  fun stop()
  fun start()
  fun destroy()

  companion object {
    /** The codec used by TencentMapApi. */
    val codec: MessageCodec<Any?> by lazy {
      TencentMapApiCodec
    }
    /** Sets up an instance of `TencentMapApi` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: TencentMapApi?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setMapType", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val typeArg = MapType.ofRaw(args[0] as Int)!!
            var wrapped: List<Any?>
            try {
              api.setMapType(typeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setCompassEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setCompassEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setScaleControlsEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setScaleControlsEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setRotateGesturesEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setRotateGesturesEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setScrollGesturesEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setScrollGesturesEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setZoomGesturesEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setZoomGesturesEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setTiltGesturesEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setTiltGesturesEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setIndoorViewEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setIndoorViewEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setTrafficEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setTrafficEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setBuildingsEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setBuildingsEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setMyLocationButtonEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setMyLocationButtonEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setMyLocationEnabled", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val enabledArg = args[0] as Boolean
            var wrapped: List<Any?>
            try {
              api.setMyLocationEnabled(enabledArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setMyLocation", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val locationArg = args[0] as Location
            var wrapped: List<Any?>
            try {
              api.setMyLocation(locationArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.setUserLocationType", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val typeArg = UserLocationType.ofRaw(args[0] as Int)!!
            var wrapped: List<Any?>
            try {
              api.setUserLocationType(typeArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.moveCamera", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val positionArg = args[0] as CameraPosition
            val durationArg = args[1].let { if (it is Int) it.toLong() else it as Long }
            var wrapped: List<Any?>
            try {
              api.moveCamera(positionArg, durationArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.addMarker", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val optionsArg = args[0] as MarkerOptions
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.addMarker(optionsArg))
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.addPolyline", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val optionsArg = args[0] as PolylineOptions
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.addPolyline(optionsArg))
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.pause", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.pause()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.resume", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.resume()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.stop", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.stop()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.start", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.start()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapApi.destroy", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              api.destroy()
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object MarkerApiCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Bitmap.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Position.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is Bitmap -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is Position -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface MarkerApi {
  fun remove(id: String)
  fun setRotation(id: String, rotation: Double)
  fun setPosition(id: String, position: Position)
  fun setAnchor(id: String, x: Double, y: Double)
  fun setZIndex(id: String, zIndex: Long)
  fun setAlpha(id: String, alpha: Double)
  fun setIcon(id: String, icon: Bitmap)
  fun setDraggable(id: String, draggable: Boolean)

  companion object {
    /** The codec used by MarkerApi. */
    val codec: MessageCodec<Any?> by lazy {
      MarkerApiCodec
    }
    /** Sets up an instance of `MarkerApi` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: MarkerApi?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.remove", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            var wrapped: List<Any?>
            try {
              api.remove(idArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setRotation", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val rotationArg = args[1] as Double
            var wrapped: List<Any?>
            try {
              api.setRotation(idArg, rotationArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setPosition", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val positionArg = args[1] as Position
            var wrapped: List<Any?>
            try {
              api.setPosition(idArg, positionArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setAnchor", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val xArg = args[1] as Double
            val yArg = args[2] as Double
            var wrapped: List<Any?>
            try {
              api.setAnchor(idArg, xArg, yArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setZIndex", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val zIndexArg = args[1].let { if (it is Int) it.toLong() else it as Long }
            var wrapped: List<Any?>
            try {
              api.setZIndex(idArg, zIndexArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setAlpha", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val alphaArg = args[1] as Double
            var wrapped: List<Any?>
            try {
              api.setAlpha(idArg, alphaArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setIcon", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val iconArg = args[1] as Bitmap
            var wrapped: List<Any?>
            try {
              api.setIcon(idArg, iconArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.MarkerApi.setDraggable", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val idArg = args[0] as String
            val draggableArg = args[1] as Boolean
            var wrapped: List<Any?>
            try {
              api.setDraggable(idArg, draggableArg)
              wrapped = listOf<Any?>(null)
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object TencentMapHandlerCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          CameraPosition.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Location.fromList(it)
        }
      }
      130.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          MapPoi.fromList(it)
        }
      }
      131.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          Position.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is CameraPosition -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is Location -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      is MapPoi -> {
        stream.write(130)
        writeValue(stream, value.toList())
      }
      is Position -> {
        stream.write(131)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated class from Pigeon that represents Flutter messages that can be called from Kotlin. */
@Suppress("UNCHECKED_CAST")
class TencentMapHandler(private val binaryMessenger: BinaryMessenger) {
  companion object {
    /** The codec used by TencentMapHandler. */
    val codec: MessageCodec<Any?> by lazy {
      TencentMapHandlerCodec
    }
  }
  /** 当点击地图上任意地点时会触发该回调，方法会传入点击的坐标点，事件可能被上层覆盖物拦截 */
  fun onPress(positionArg: Position, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onPress", codec)
    channel.send(listOf(positionArg)) {
      callback()
    }
  }
  /** 当地图上任意地点进行长按点击时会触发该回调，事件可能被上层覆盖物拦截（Android Only） */
  fun onLongPress(positionArg: Position, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onLongPress", codec)
    channel.send(listOf(positionArg)) {
      callback()
    }
  }
  /** 当点击地图上任意的POI时调用，方法会传入点击的POI信息 */
  fun onTapPoi(poiArg: MapPoi, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onTapPoi", codec)
    channel.send(listOf(poiArg)) {
      callback()
    }
  }
  /** 当地图视野即将改变时会触发该回调（iOS Only） */
  fun onCameraMoveStart(cameraPositionArg: CameraPosition, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onCameraMoveStart", codec)
    channel.send(listOf(cameraPositionArg)) {
      callback()
    }
  }
  /** 当地图视野发生变化时触发该回调。视野持续变化时本回调可能会被频繁多次调用, 请不要做耗时或复杂的事情 */
  fun onCameraMove(cameraPositionArg: CameraPosition, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onCameraMove", codec)
    channel.send(listOf(cameraPositionArg)) {
      callback()
    }
  }
  /** 当地图视野变化完成时触发该回调，需注意当前地图状态有可能并不是稳定状态 */
  fun onCameraMoveEnd(cameraPositionArg: CameraPosition, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onCameraMoveEnd", codec)
    channel.send(listOf(cameraPositionArg)) {
      callback()
    }
  }
  /** 当点击点标记时触发该回调（Android Only） */
  fun onTapMarker(markerIdArg: String, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onTapMarker", codec)
    channel.send(listOf(markerIdArg)) {
      callback()
    }
  }
  /** 当开始拖动点标记时触发该回调（Android Only） */
  fun onMarkerDragStart(markerIdArg: String, positionArg: Position, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onMarkerDragStart", codec)
    channel.send(listOf(markerIdArg, positionArg)) {
      callback()
    }
  }
  /** 当拖动点标记时触发该回调（Android Only） */
  fun onMarkerDrag(markerIdArg: String, positionArg: Position, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onMarkerDrag", codec)
    channel.send(listOf(markerIdArg, positionArg)) {
      callback()
    }
  }
  /** 当拖动点标记完成时触发该回调（Android Only） */
  fun onMarkerDragEnd(markerIdArg: String, positionArg: Position, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onMarkerDragEnd", codec)
    channel.send(listOf(markerIdArg, positionArg)) {
      callback()
    }
  }
  /** 当前位置改变时触发该回调（Android Only） */
  fun onLocation(locationArg: Location, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.tencent_map.TencentMapHandler.onLocation", codec)
    channel.send(listOf(locationArg)) {
      callback()
    }
  }
}
