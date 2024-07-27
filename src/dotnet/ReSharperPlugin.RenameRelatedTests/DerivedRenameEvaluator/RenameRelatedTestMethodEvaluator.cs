using System;
using System.Collections.Generic;
using System.Linq;
using JetBrains.Application.Progress;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp.Tree;
using JetBrains.ReSharper.Psi.Resolve;
using JetBrains.ReSharper.Refactorings.Rename;

namespace ReSharperPlugin.RenameRelatedTests.DerivedRenameEvaluator;

[DerivedRenamesEvaluator]
public class RenameRelatedTestMethodEvaluator : IDerivedRenamesEvaluator
{
    public bool SuggestedElementsHaveDerivedName => true;

    public IEnumerable<IDeclaredElement> CreateFromElement(IEnumerable<IDeclaredElement> initialElements, DerivedElement derivedElement, IProgressIndicator pi)
    {
            return Array.Empty<IDeclaredElement>();
        }

    public IEnumerable<IDeclaredElement> CreateFromReference(IReference reference, IDeclaredElement declaredElement, IProgressIndicator pi)
    {
            if (!(reference.GetTreeNode() is ICSharpTreeNode cSharpTreeNode))
                return Array.Empty<IDeclaredElement>();
            var containingFunction = cSharpTreeNode.GetContainingFunctionDeclarationIgnoringClosures();
            if (containingFunction == null)
                return Array.Empty<IDeclaredElement>();

            if (MatchName(declaredElement.ShortName, containingFunction.DeclaredName))
                return new[] {containingFunction.DeclaredElement};
            if (MatchName(declaredElement.ShortName.Replace("Async", ""), containingFunction.DeclaredName))
                return new[] {containingFunction.DeclaredElement};


            return Array.Empty<IDeclaredElement>();
        }

    private bool MatchName(string renamedElementName, string candidateName)
    {
            var tokenizedRenamed = TextUtil.TokenizeKeepCase(renamedElementName);
            var tokenizedCandidate = TextUtil.TokenizeKeepCase(candidateName);

            if (tokenizedRenamed.Count > tokenizedCandidate.Count)
                return false;
            var searchedName = string.Join("", tokenizedRenamed);
            for (var i = 0; i < tokenizedCandidate.Count - (tokenizedRenamed.Count - 1); i++)
            {
                if (string.Join("", tokenizedCandidate.Skip(i).Take(tokenizedRenamed.Count)) == searchedName)
                    return true;
            }

            return false;
        }
}