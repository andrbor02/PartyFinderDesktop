package feature_event_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import core_data.DataSource
import core_data.partyfinder_db.company.model.DataCompany
import core_data.partyfinder_db.debt.model.DataDebt
import core_data.partyfinder_db.event.model.DataEvent
import core_data.partyfinder_db.event_type.model.DataEventType
import core_data.partyfinder_db.item.model.DataItem

@Composable
fun EventListScreen(
    dbEventDataSource: DataSource<DataCompany>,
) {
    val eventList = dbEventDataSource.get()

    LazyColumn(
        modifier = Modifier
            .padding(24.dp)
            .background(color = Color.White)
            .fillMaxSize()
            .zIndex(1f),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        eventList.map {
            item { Text(it.toString()) }
        }
    }
}