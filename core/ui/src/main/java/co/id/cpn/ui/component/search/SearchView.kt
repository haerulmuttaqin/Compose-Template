package co.id.cpn.ui.component.search

import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.id.cpn.common.R
import co.id.cpn.ui.theme.AppTheme
import co.id.cpn.ui.theme.inputBackground
import co.id.cpn.ui.theme.onInputBackground

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .background(MaterialTheme.colors.inputBackground)
                .clickable {
                    onClick.invoke()
                }
                .fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
                imageVector = Icons.Rounded.Search,
                contentDescription = stringResource(id = R.string.nav_search)
            )
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                text = text,
                color = MaterialTheme.colors.onInputBackground
            )
        }
    }
}

@Preview
@Composable
fun SearchViewPreview() {
    AppTheme {
        SearchView(text = "Search Product", onClick = {})
    }
}