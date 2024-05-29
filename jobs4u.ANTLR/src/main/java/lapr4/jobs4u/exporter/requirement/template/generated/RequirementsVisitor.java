package lapr4.jobs4u.exporter.requirement.template.generated;
// Generated from Requirements.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RequirementsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RequirementsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RequirementsParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(RequirementsParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link RequirementsParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(RequirementsParser.ContentContext ctx);
}