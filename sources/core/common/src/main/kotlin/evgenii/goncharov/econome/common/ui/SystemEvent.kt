package evgenii.goncharov.econome.common.ui

public sealed class SystemEvent {

    public data object InitialState : SystemEvent()

    public data class ShowToast(
        val messageToast: String
    ) : SystemEvent()
}