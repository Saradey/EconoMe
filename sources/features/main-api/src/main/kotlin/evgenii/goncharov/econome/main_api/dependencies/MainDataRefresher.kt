package evgenii.goncharov.econome.main_api.dependencies

public interface MainDataRefresher {

    public var refreshListener: (() -> Unit)?

    public fun refreshData()
}